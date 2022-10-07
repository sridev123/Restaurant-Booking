package org.example;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import org.example.model.Reservation;

import java.time.LocalDate;
import java.util.*;

public class App {
    public static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
        MuServer server = MuServerBuilder.httpServer().addHandler(Method.POST, "/reserve", (request, response, pathParams) -> {
            String custName = request.query().get("custName");
            int numOfGuests = Integer.parseInt(request.query().get("numOfGuests"));
            LocalDate date = LocalDate.parse(request.query().get("bookingDate"));
            String custId = UUID.randomUUID().toString();
            reservations.put(custId, new Reservation(custName, numOfGuests, date));
            response.write("BOOKING CONFIRMED FOR " + custName + "Booking id " + custId);
        }).addHandler(Method.GET, "/allbookings", (request, response, pathParams) -> {
            System.out.println(reservations);
            if (request.query().contains("date")) {
                LocalDate date = LocalDate.parse(request.query().get("date"));
               List<Reservation> reservationList = new ArrayList<>();
                for (Map.Entry<String, Reservation> reservation : reservations.entrySet()) {
                    if (reservation.getValue().getDate().equals(date)) {
                        reservationList.add(reservation.getValue());
                    }
                }
                response.write(String.valueOf(reservationList));
            } else {
                response.write("Please input date for which reservations needs to be displayed");
            }
        }).start();
        System.out.println("Started server at " + server.uri());
    }
}
