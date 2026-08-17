public class Main {

    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        Transaction t1 = new Transaction("Alice", "Bob", 10);

        Block block1 = new Block(
                t1.toString(),
                blockchain.getLatestBlock().hash
        );

        blockchain.addBlock(block1);

        Transaction t2 = new Transaction("Bob", "Charlie", 5);

        Block block2 = new Block(
                t2.toString(),
                blockchain.getLatestBlock().hash
        );

        blockchain.addBlock(block2);

        for (Block block : blockchain.chain) {
            System.out.println("Data: " + block.data);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Hash: " + block.hash);
            System.out.println();
        }
    }
}
