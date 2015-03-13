package CVRP.utils;

import CVRP.FileProcessing.TLFileReader;
import CVRP.FileProcessing.TLFileWriter;

public class TLRandom {
    
    long seed;
    long GMod = 2439719328107L;

    public TLRandom() {
        readSeed();
    }
    
    public void setSeed(long seed) {
        this.seed = seed;
    }
    
    public void saveSeed() {
        TLFileWriter writer = new TLFileWriter("Seed", "Random", false);
        TLArrayList<String> seedList = new TLArrayList<String>();
        seedList.add(String.valueOf(seed));
        writer.write(seedList);
    }

    private void readSeed() {
        TLFileReader reader = new TLFileReader("Seed", "Random");
        if (!reader.fileExists()) {
            this.seed = 8645753532752L;
            return;
        }
        TLArrayList<String> seedList = reader.getRivit();
        this.seed = Long.parseLong(seedList.get(0));
    }
    
    private long mod(long number, long mod) {
        long answer = number%mod;
        if (answer < 0) {
            answer += mod;
        }
        return answer;
    }
    
    public int nextInt(int bound) {
        return (int) nextLong(bound);
        
    }
    
    public long nextLong(long bound) {
        this.seed = mod(((long) Math.pow(seed, 2)), GMod);
        long answer = mod(seed, bound);
        return answer;
    }
    
}
