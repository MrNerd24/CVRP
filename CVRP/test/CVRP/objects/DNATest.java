/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CVRP.objects;

import CVRP.algorithm.Rules;
import CVRP.utils.TLArrayList;
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
public class DNATest {

    public Rules rules;

    public DNATest() {
        rules = new Rules(20, 20, 10, 0.99);

        rules.getLocations().add(new Location(0, 7, 8));
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
    public void testMutate() {
        // Voi olla että testi epäonnistuu joskus koska on mahdollista että mutaatioita ei tapahdu. Kannattaa testata pari kertaa ja huolestua jos kokoajan epäonnistuu.
        DNA dna = new DNA(true, rules);
        dna.calculateFitness();
        int fitness1 = dna.getFitness();
        dna.mutate(10000);
        dna.calculateFitness();
        int fitness2 = dna.getFitness();
        System.out.println("Mutation test: " + fitness1 + " vs " + fitness2);
        assertEquals(true, fitness1 != fitness2);

    }

    @Test
    public void testCalculateFitness() {
        DNA dna = new DNA(false, rules);
        dna.getRunningOrder().get(0).add(rules.getLocations().get(0));
        dna.getRunningOrder().get(0).add(rules.getLocations().get(8));
        dna.getRunningOrder().get(0).add(rules.getLocations().get(10));
        dna.getRunningOrder().get(0).add(rules.getLocations().get(3));
        dna.calculateFitness();
        assertEquals(31, dna.getFitness());
    }

    @Test
    public void testCalculateDifference() {
        DNA daddy = new DNA(false, rules);
        DNA mommy = new DNA(false, rules);
        DNA instance = new DNA(false, rules);

        daddy.getRunningOrder().get(0).add(rules.getLocations().get(11));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(12));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(13));
        
        daddy.getRunningOrder().get(0).add(rules.getLocations().get(4));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(4));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(4));
        
        daddy.getRunningOrder().get(0).add(rules.getLocations().get(8));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(8));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(8));
        
        daddy.getRunningOrder().get(0).add(rules.getLocations().get(10));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(10));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(10));
        
        instance.calculateDifference(daddy, mommy);
        assertEquals(29, instance.getDifference());
    }

    @Test
    public void testCalculateScore() {
        DNA daddy = new DNA(false, rules);
        DNA mommy = new DNA(false, rules);
        DNA instance = new DNA(false, rules);

        daddy.getRunningOrder().get(0).add(rules.getLocations().get(11));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(12));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(2));
        
        daddy.getRunningOrder().get(0).add(rules.getLocations().get(4));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(4));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(4));
        
        daddy.getRunningOrder().get(0).add(rules.getLocations().get(8));
        mommy.getRunningOrder().get(0).add(rules.getLocations().get(8));
        instance.getRunningOrder().get(0).add(rules.getLocations().get(8));
        
        instance.calculateDifference(daddy, mommy);
        instance.calculateFitness();
        instance.calculateScore();
        assertEquals(18, instance.getScore());
        
    }



}
