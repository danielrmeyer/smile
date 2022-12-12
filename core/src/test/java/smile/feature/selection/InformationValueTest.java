/*
 * Copyright (c) 2010-2021 Haifeng Li. All rights reserved.
 *
 * Smile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Smile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Smile.  If not, see <https://www.gnu.org/licenses/>.
 */

package smile.feature.selection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import smile.test.data.BreastCancer;
import smile.test.data.Default;
import smile.test.data.Weather;

/**
 *
 * @author Haifeng Li
 */
public class InformationValueTest {

    public InformationValueTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDefault() {
        System.out.println("Default");

        InformationValue model = InformationValue.fit(Default.formula, Default.data);
        System.out.println(model);

        double[] iv = model.iv();
        assertEquals(3, iv.length);
        assertEquals(0.0364, iv[0], 1E-4);
        assertEquals(4.2638, iv[1], 1E-4);
        assertEquals(0.0664, iv[2], 1E-4);
    }

    @Test
    public void testBreastCancer() {
        System.out.println("BreastCancer");

        InformationValue model = InformationValue.fit(BreastCancer.formula, BreastCancer.data);
        System.out.println(model);

        double[] iv = model.iv();
        assertEquals(30, iv.length);
        assertEquals(0.2425, iv[ 9], 1E-4);
        assertEquals(0.1002, iv[11], 1E-4);
        assertEquals(0.0817, iv[14], 1E-4);
    }

    @Test
    public void testWeather() {
        System.out.println("Weather");

        InformationValue model = InformationValue.fit(Weather.formula, Weather.data);
        System.out.println(model);

        double[] iv = model.iv();
        assertEquals(4, iv.length);
        assertEquals(0.9012, iv[0], 1E-4);
        assertEquals(0.6291, iv[1], 1E-4);
        assertEquals(0.6291, iv[2], 1E-4);
        assertEquals(0.2930, iv[3], 1E-4);
    }
}