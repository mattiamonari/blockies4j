package blockies;

public class ColorUtilities {


    /** Converts a given HSL(Hue Saturation Lightness)-color to RGB
     *
     * @param h The hue of the color(0-360)
     * @param s The saturation of the color(0-1)
     * @param l The lightness(or brightness) of the color(0-1)
     * @return An integer-array containing values from 0 to 255 in order RGB.
     * Adapted from https://www.demo2s.com/java/java-color-convert-hsl-values-to-a-rgb-color.html.
     */
    public static int[] HSLtoRGB(float h, float s, float l, float alpha) {


        if (s < 0.0f || s > 100.0f) {
            String message = "Color parameter outside of expected range - Saturation";
            throw new IllegalArgumentException(message);
        }

        if (l < 0.0f || l > 100.0f) {
            String message = "Color parameter outside of expected range - Luminance";
            throw new IllegalArgumentException(message);
        }

        if (alpha < 0.0f || alpha > 1.0f) {
            String message = "Color parameter outside of expected range - Alpha";
            throw new IllegalArgumentException(message);
        }

        h = h % 360.0f;
        h /= 360f;
        s /= 100f;
        l /= 100f;

        float q = 0;

        if (l < 0.5)
            q = l * (1 + s);
        else
            q = (l + s) - (s * l);

        float p = 2 * l - q;

        int r = Math.round(Math.max(0, HueToRGB(p, q, h + (1.0f / 3.0f)) * 255));
        int g = Math.round(Math.max(0, HueToRGB(p, q, h) * 255));
        int b = Math.round(Math.max(0, HueToRGB(p, q, h - (1.0f / 3.0f)) * 255));

        int[] array = { r, g, b };
        return array;
    }

    private static float HueToRGB(float p, float q, float h) {
        if (h < 0)
            h += 1;

        if (h > 1)
            h -= 1;

        if (6 * h < 1) {
            return p + ((q - p) * 6 * h);
        }

        if (2 * h < 1) {
            return q;
        }

        if (3 * h < 2) {
            return p + ((q - p) * 6 * ((2.0f / 3.0f) - h));
        }

        return p;
    }
}
