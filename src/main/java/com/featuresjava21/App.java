package com.featuresjava21;

import com.featuresjava21.patternmatchingforswitch.PatternSwitch;
import com.featuresjava21.recordpatterns.RecordPatterns;
import com.featuresjava21.utils.Admin;
import com.featuresjava21.utils.Days;
import com.featuresjava21.utils.User;
import com.featuresjava21.utils.Utils;

public class App {
        public static void main(String[] args) {
                // intro
                RecordPatterns.validateInstancePriorOfJava16("Perú Java 1");
                RecordPatterns.validateInstanceAsOfJava16("Perú Java 2");

                // feature (440) Record Patterns (440)
                RecordPatterns.Point point = new RecordPatterns.Point(12, 3);
                RecordPatterns.printSumClasicJava16(point);
                RecordPatterns.printSumAsOfJava21(point);
                RecordPatterns.ColoredPoint pointColor = new RecordPatterns.ColoredPoint(point,
                                RecordPatterns.Color.RED);
                RecordPatterns.printUpperLeftColoredPoint(new RecordPatterns.Rectangle(pointColor, pointColor));
                RecordPatterns.printColorOfUpperLeftPoint(new RecordPatterns.Rectangle(pointColor, pointColor));
                RecordPatterns.printXCoordOfUpperLeftPointWithPatterns(
                                new RecordPatterns.Rectangle(pointColor, pointColor));

                // feature (441): Pattern matching for Swich
                Utils.print(PatternSwitch.formatterPriorOfJava21("Prueba Formateo antes de Java 21"));
                Utils.print(PatternSwitch.formatterSwitchForAnyType("Prueba Switch mejorado con Java 21"));
                PatternSwitch.evaluateSwitchAndNullClassicExpression(null);
                PatternSwitch.evaluateSwitchAndNullExpressionInJava21(null);
                PatternSwitch.testStringOld("NO");
                PatternSwitch.testStringEnhanced("Y");
                // PatternSwitch.exhaustiveSwitchWithBetterEnumSupport( );
                Utils.print(PatternSwitch.selectorWithLambdaforEnumsCases(Days.MARTES));
                User user = new Admin();
                Utils.print(PatternSwitch.selectionWithInstancesCases(user));

        }
}
