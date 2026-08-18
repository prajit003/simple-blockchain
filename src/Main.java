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

        System.out.println();
        System.out.println("Blockchain valid: "
                + blockchain.isChainValid());

        System.out.println();
        System.out.println("Tampering with Block 1...");

        blockchain.chain.get(1).data = "Alice -> Bob : 1000";

        System.out.println("Blockchain valid after tampering: "
                + blockchain.isChainValid());
    }
}