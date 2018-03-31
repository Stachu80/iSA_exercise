package geomap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/geomaps")
public class GeoMap extends HttpServlet {

    private static final String apiKey = "AIzaSyApzO6M1t548pD_AsXkJWYM4PrWJXrf8DM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        geo(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        geo(req, resp);
    }

    public void geo(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String adress = req.getParameter("adress") == null ? "" : req.getParameter("adress");

        System.out.println(req.getParameter("city")+" adress           "   +adress);
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
        GeocodingResult[] results = new GeocodingResult[0];

        try {
            results = GeocodingApi.geocode(context,
                    adress).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (results.length > 0) {
            req.setAttribute("latitude", gson.toJson(results[0].geometry.location.lat));
            req.setAttribute("longitude", gson.toJson(results[0].geometry.location.lng));

            System.out.println(gson.toJson(results[0].postcodeLocalities));
        }else{
            System.out.println("lipa");
        }

        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("key", apiKey + "&callback");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log("problem with page: " + e);
        }
    }
}
