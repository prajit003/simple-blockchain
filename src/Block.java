import java.security.MessageDigest;

public class Block {

    String data;
    String previousHash;
    String hash;
    long timestamp;
    int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.nonce = 0;

        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String input = data + previousHash + timestamp + nonce;

            byte[] hashBytes = digest.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void mineBlock(int difficulty) {

    String target = "0".repeat(difficulty);

    while (!hash.substring(0, difficulty).equals(target)) {

        nonce++;

        hash = calculateHash();
    }

    System.out.println("Block mined: " + hash);
}
}
