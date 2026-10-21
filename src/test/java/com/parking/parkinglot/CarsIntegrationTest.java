package com.parking.parkinglot;

import com.parking.parkinglot.servlets.Cars;
import jakarta.servlet.annotation.WebServlet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CarsIntegrationTest {

    @Test
    void carsServletAnnotationPresent() {
        WebServlet annotation = Cars.class.getAnnotation(WebServlet.class);
        assertNotNull(annotation, "Cars servlet should be annotated with @WebServlet");
        assertEquals("Cars", annotation.name());
        assertArrayEquals(new String[]{"/Cars"}, annotation.value());
    }

    @Test
    void carsJspExistsAndContainsRequiredElements() throws IOException {
        Path carsJsp = Path.of("src/main/webapp/WEB-INF/pages/cars.jsp");
        assertTrue(Files.exists(carsJsp), "cars.jsp should exist in WEB-INF/pages");

        String content = Files.readString(carsJsp);
        assertTrue(content.contains("pageTitle=\"Cars\""), "cars.jsp should have pageTitle 'Cars'");
        assertTrue(content.contains("${numberOfFreeParkingSpots}"), "cars.jsp should reference numberOfFreeParkingSpots");
        assertTrue(content.contains("Car 1"), "cars.jsp should contain Car 1 sample row");
    }

    @Test
    void menuContainsAboutAndCarsNavigation() throws IOException {
        Path menuJsp = Path.of("src/main/webapp/WEB-INF/pages/menu.jsp");
        assertTrue(Files.exists(menuJsp), "menu.jsp should exist in WEB-INF/pages");

        String content = Files.readString(menuJsp);
        assertTrue(content.contains("/about.jsp"), "menu.jsp should link to about.jsp");
        assertTrue(content.contains("/Cars"), "menu.jsp should link to /Cars");
        assertTrue(content.contains("activePage eq 'Cars'"), "menu.jsp should handle active status for Cars");
    }

    @Test
    void footerExists() throws IOException {
        Path footerJsp = Path.of("src/main/webapp/WEB-INF/pages/footer.jsp");
        assertTrue(Files.exists(footerJsp), "footer.jsp should exist in WEB-INF/pages");

        String content = Files.readString(footerJsp);
        assertTrue(content.contains("&copy;"), "footer.jsp should contain copyright");
    }
}
