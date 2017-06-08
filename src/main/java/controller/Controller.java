package controller;

import dao.PointDao;
import dao.RestaurantPoi;
import model.Point;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.*;

/**
 * The {@link Controller} class responsible to control the app process.
 * <p>
 * This class render the index.html page and calculate the nearest point.
 *
 * @author      Kelemen Gergo
 * @version     1.8
 */
public class Controller {
    private PointDao pointDao = new RestaurantPoi();

    /**
     * Render to the index page.
     *
     * @param req {@link Request} object from the request
     * @param res {@link Response} object from the response
     * @return a new {@link ModelAndView} instance, with index viewName
     */
    public ModelAndView renderIndex(Request req, Response res) {
        return new ModelAndView(new HashMap(), "index");
    }

    /**
     * Calculate the nearest point and based on the x and y coordinates.
     *
     * @return with the nearest point ({@link Point} instance)
     */
    public Point calculateNearestFromLastSearchedPoint() {
        Point foundedPoint = pointDao.getNearestPoint();

        double minDistance = pointDao.getNearestDistance();
        System.out.println("Distance: " + minDistance + " rest: " + foundedPoint.getName());
        return foundedPoint;
    }
}
