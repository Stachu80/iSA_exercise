package bank;

import bank.model.Repayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bank")
public class Bank extends HttpServlet {


    private final Logger logger = LoggerFactory.getLogger(Bank.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calculate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        calculate(req, resp);
    }

    public void calculate(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        double sumOfAllInterest = 0;
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        Integer credit = getInteger(req.getParameter("credit"));
        Integer month = getInteger(req.getParameter("month"));
        Integer interest = getInteger(req.getParameter("interest"));
        Integer commission = getInteger(req.getParameter("commission"));

        req.setAttribute("credit", credit);
        req.setAttribute("month", month);
        req.setAttribute("interest", interest);
        req.setAttribute("commission", commission);

        List<Repayment> repayment = new ArrayList<>();
        if (isEmpty(credit) || isEmpty(month) || isEmpty(interest) || isEmpty(commission)) {
            req.setAttribute("warning", "nie wypelniłeś wszystkich pól");
        } else {
            Integer baseValueWithCommission = credit + (commission * credit / 100);
            Integer baseValue = credit;
            for (int i = 0; i < month; i++) {
                baseValue -= (baseValue / month);


                double interestInMonth = Math.round(((interest.doubleValue() / 12) * baseValue) / 100);
                sumOfAllInterest += interestInMonth;

                Repayment row = new Repayment();
                row.setInterrest(interestInMonth);
                row.setToRepay(baseValue);
                repayment.add(row);

            }
            System.out.println(sumOfAllInterest);
            double installment = Math.round((baseValueWithCommission + sumOfAllInterest) / month);
            double theTotalAmountToBeRepaid = installment * month;
            double bankProfit = theTotalAmountToBeRepaid - credit;
            double RRSO = ((bankProfit * 12 / month) / (credit / 2)) * 100;

            String numberAsString = String.format("%.2f", RRSO);

            req.setAttribute("theTotalAmountToBeRepaid", theTotalAmountToBeRepaid);
            req.setAttribute("repayment", repayment);
            req.setAttribute("installment", installment);
            req.setAttribute("baseValueWithCommission", baseValueWithCommission);
            req.setAttribute("rrso", numberAsString);

            repayment.stream().forEach(r -> r.setCapital(installment - r.getInterrest()));


        }

        showPage(req, resp);
    }

    private static Integer getInteger(String str) {
        if (str.equals("")) {
            return null;
        } else {
            return Integer.parseInt(str);
        }
    }

    private boolean isEmpty(Integer value) {
        return value == null;
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            logger.warn("problem z wyświetleniem strony");
        }
    }
}
