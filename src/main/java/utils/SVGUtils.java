package utils;

import java.io.File;

public class SVGUtils {

    private static final Integer DELTA = 10;
    private static final Integer SCREEN_WIDTH = 1000;
    private static final Integer SCREEN_HEIGHT = 1000;
    private static  final String OUT_FILE = "out.svg";

    private static void insertPath(StringBuilder sb,enOrientation orientation,Integer[] ref)
    {

        switch (orientation)
        {
            case ZERO_DEGREES:
                sb.append("<path d=\"M"+ ref[0] + " " + ref[1] +" h10 \" stroke=\"black\" stroke-width=\"3\"/>\n");
                ref[0] += DELTA;
                break;

            case NINETY_DEGREES:
                sb.append("<path d=\"M"+ ref[0] + " " + ref[1] +" v10 \" stroke=\"black\" stroke-width=\"3\"/>\n");
                ref[1] += DELTA;
                break;

            case ONE_HUNDRED_AND_EIGHTH_DEGREES:
                sb.append("<path d=\"M"+ ref[0] + " " + ref[1] +" h10 \" stroke=\"black\" stroke-width=\"3\"/>\n");
                ref[0] -= DELTA;
                break;

            case TWO_HUNDRED_AND_SEVENTY:
                sb.append("<path d=\"M"+ ref[0] + " " + ref[1] +" h10 \" stroke=\"black\" stroke-width=\"3\"/>\n");
                ref[1] -= DELTA;
                break;

            default:

                break;


        }
    }

    private static void deleteLastSVG()
    {
        File mSvgFile = new File(OUT_FILE);
        if(mSvgFile.exists())
        {
            mSvgFile.delete();
        }
    }


    public static void drawSVGWithGrammar(StringBuilder g)
    {

        int degreeRef = 0;

        deleteLastSVG();

        StringBuilder sb = new StringBuilder();
        Integer[] ref = new Integer[2];
        ref[0] = SCREEN_WIDTH/2;
        ref[1] = SCREEN_HEIGHT/2;
        //insert header
        sb.append("<svg width=\"" + SCREEN_WIDTH +"\" height=\"" + SCREEN_HEIGHT + "\" xmlns=\"http://www.w3.org/2000/svg\">\n");

        for(int i = 0; i<g.length();i++)
        {
            switch (g.charAt(i))
            {
                case '+':
                    if(degreeRef < 3)
                        degreeRef++;
                    else
                        degreeRef = 0;
                    break;

                case '-':
                    if(degreeRef == 0)
                        degreeRef = 3;
                    else
                        degreeRef--;
                    break;

                case 'D':
                    insertPath(sb,enOrientation.values()[degreeRef],ref);
                    break;
            }
        }

        sb.append("</svg>");
        TextUtils.write(sb.toString(),OUT_FILE);
    }

}
