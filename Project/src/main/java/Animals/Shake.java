package Animals;

import javafx.animation.TranslateTransition;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Shake {
    public TranslateTransition animals;

    public Shake(TextField node){
        animals = new TranslateTransition(Duration.millis(70), node);
        animals.setFromX(0f);
        animals.setByX(10f);
        animals.setCycleCount(3);
        animals.setAutoReverse(true);
    }
    public void playAnim(){
        animals.playFromStart();
    }
}
