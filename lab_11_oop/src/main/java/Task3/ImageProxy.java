package Task3;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ImageProxy implements MyImage {
    @Getter
    private RealImage realImage;
    private final String imageName;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void display() {
        if (realImage == null)
            realImage = new RealImage(imageName);
        realImage.display();
    }
}
