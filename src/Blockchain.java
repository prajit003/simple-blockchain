import java.util.ArrayList;

public class Blockchain {

    ArrayList<Block> chain;
    int difficulty;

    public Blockchain() {
        chain = new ArrayList<>();
        difficulty = 4;

        chain.add(new Block("Genesis Block", "0"));
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block block) {
        block.mineBlock(difficulty);
        chain.add(block);
    }

    public boolean isChainValid() {

        for (int i = 1; i < chain.size(); i++) {

            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                return false;
            }
        }

        return true;
    }
}