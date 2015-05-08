/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CVRP.algorithm;

import CVRP.objects.Car;
import CVRP.objects.DNA;
import CVRP.objects.Location;
import CVRP.objects.Packet;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juuso
 */
public class SolverTest {

    public Rules rules;

    public SolverTest() {
        rules = new Rules(100, 100, 10, 0.99, 7, 8);

        rules.getLocations().add(new Location(1, 10, 10));
        rules.getLocations().add(new Location(2, 10, 13));
        rules.getLocations().add(new Location(3, 16, 7));
        rules.getLocations().add(new Location(4, 5, 5));
        rules.getLocations().add(new Location(5, 11, 4));
        rules.getLocations().add(new Location(6, 17, 13));
        rules.getLocations().add(new Location(7, 17, 17));
        rules.getLocations().add(new Location(8, 4, 10));
        rules.getLocations().add(new Location(9, 14, 11));
        rules.getLocations().add(new Location(10, 10, 7));
        rules.getLocations().add(new Location(11, 5, 15));
        rules.getLocations().add(new Location(12, 11, 17));
        rules.getLocations().add(new Location(13, 16, 4));
        rules.getLocations().add(new Location(14, 20, 9));

        rules.getLocations().get(1).getPackets().add(new Packet(1, 4));
        rules.getLocations().get(2).getPackets().add(new Packet(2, 3));
        rules.getLocations().get(2).getPackets().add(new Packet(3, 5));
        rules.getLocations().get(3).getPackets().add(new Packet(4, 8));
        rules.getLocations().get(3).getPackets().add(new Packet(5, 1));
        rules.getLocations().get(4).getPackets().add(new Packet(6, 1));
        rules.getLocations().get(4).getPackets().add(new Packet(7, 1));
        rules.getLocations().get(4).getPackets().add(new Packet(8, 2));
        rules.getLocations().get(5).getPackets().add(new Packet(9, 9));
        rules.getLocations().get(6).getPackets().add(new Packet(10, 1));
        rules.getLocations().get(6).getPackets().add(new Packet(11, 9));
        rules.getLocations().get(7).getPackets().add(new Packet(12, 3));
        rules.getLocations().get(8).getPackets().add(new Packet(13, 10));
        rules.getLocations().get(10).getPackets().add(new Packet(14, 2));
        rules.getLocations().get(10).getPackets().add(new Packet(15, 5));
        rules.getLocations().get(11).getPackets().add(new Packet(16, 7));
        rules.getLocations().get(11).getPackets().add(new Packet(17, 7));
        rules.getLocations().get(12).getPackets().add(new Packet(18, 1));
        rules.getLocations().get(13).getPackets().add(new Packet(19, 6));
        rules.getLocations().get(14).getPackets().add(new Packet(20, 10));
        rules.getLocations().get(14).getPackets().add(new Packet(21, 11));

        rules.getCars().add(new Car(1, 20));
        rules.getCars().add(new Car(2, 20));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoGenerations() {
        Solver solver = new Solver(rules);
        solver.doGenerations(100);
    }

    @Test
    public void testGetBest() {
        Solver solver = new Solver(rules);
        solver.doGenerations(10000);
        DNA best = solver.getBest();
        System.out.println(best.getFitness());
        System.out.println(best.getDifference());
        System.out.println(best.getScore());
        for (int i = 0; i < best.getPaths().size(); i++) {
            for (int j = 0; j < best.getPaths().get(i).size(); j++) {
                System.out.print(best.getPaths().get(i).get(j).getId() + ", ");
            }
            System.out.println("");
        }
    }
    
    // Remove @Test if you don't want this printed.
    @Test
    public void performanceTesting() {
        // Generates and prints a csv file for excel.
        System.out.println("");
        for (int cars = 2; cars <= 2; cars++) {
            System.out.println("cars: " + cars);
            for (int mut = 10; mut <= 100; mut += 2) {
                System.out.println("mut: " + mut);
                System.out.println("");
                System.out.print(",");
                for (int i = 30; i <= 30; i += 5) {
                    System.out.print(i + ",");
                }
                System.out.println("");
                for (int pac = 5; pac <= 5; pac++) {
                    System.out.print(pac + ",");
                    for (int loc = 30; loc <= 30; loc += 5) {
                        Rules rules = new Rules(1000, 1000, mut, 0.99, 250, 250);
                        addLocations(rules, loc, pac);
                        addCars(rules, cars);
                        long time = averageGenerationTime(rules);
                        System.out.print(time + ",");
                    }
                    System.out.println("");
                }
                System.out.println("");
            }
        }

    }

    public long averageGenerationTime(Rules rules) {
        Solver solver = new Solver(rules);
        long start = System.nanoTime();
        solver.doGenerations(3000);
        long end = System.nanoTime();
        long ans = (end - start) / 3000;
        return ans;
    }

    public void addLocations(Rules rules, int locations, int packets) {
        Random random = new Random();
        for (int i = 1; i <= locations; i++) {
            Location loc = new Location(i, random.nextInt(500), random.nextInt(500));

            for (int j = 0; j < packets; j++) {
                Packet pac = new Packet(j, random.nextInt(20));
                loc.getPackets().add(pac);
            }

            rules.getLocations().add(loc);
        }
    }

    public void addCars(Rules rules, int cars) {
        for (int i = 1; i <= cars; i++) {
            rules.getCars().add(new Car(i, 100));
        }
    }

}
