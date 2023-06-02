package Adaptor;

import Adaptor.FilterGallery.WarmFG;

public class Warm implements Filter{
    WarmFG warmFG;
    public Warm(WarmFG warmFG) {
        this.warmFG = warmFG;
    }

    @Override
    public void apply(String image) {
        warmFG.filter(image);
    }
}
