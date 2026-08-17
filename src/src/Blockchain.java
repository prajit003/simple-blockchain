import java.util.ArrayList;

public class Blockchain {

    ArrayList<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();

        chain.add(new Block("Genesis Block", "0"));
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block block) {
        chain.add(block);
    }
}
