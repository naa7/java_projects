package sample;
import javafx.scene.paint.Color;

public enum MyColor {
    BLACK(0,0,0),
    BLUE(0,0,255),
    CYAN(0,255,255),
    DARKRED(139,0,0),
    GREY(128,128,128),
    GREEN(0,128,0),
    LIME(0,255,0),
    LIGHTLIME(117,232,42),
    MAGENTA(255,0,255),
    MAROON(128,0,0),
    NAVYBLUE(0,0,128),
    OLIVE(128,128,0),
    PURPLE(128,0,128),
    WISTERIA(204,170,227),
    RED(255,0,0),
    SKYBLUE(135,206,250),
    TEAL(0,128,128),
    VIOLET(148,0,211),
    WHITE(255,255,255),
    YELLOW(255,255,0),
    SUNGLOW(255,206,46),
    BIEGE(239,233,196),
    LIGHTBROWN(166,103,55);

    private Color color;

    MyColor(int r, int g, int b){
        this.color = Color.rgb (r,g,b);
    }
    public Color getMyColor(){
        return color;
    }
}
