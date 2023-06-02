package Adaptor;

public class Vivid implements Filter {
    @Override
    public void apply(String image) {
        System.out.println("Applying vivid filter to " + image);
    }
}
