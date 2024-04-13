/*
 * Copyright (c) 2010-2024 Haifeng Li. All rights reserved.
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
package smile.vision;

import org.junit.jupiter.api.*;
import smile.deep.tensor.Device;
import smile.deep.tensor.Tensor;
import smile.deep.Model;

/**
 *
 * @author Haifeng Li
 */
public class EfficientNetTest {

    public EfficientNetTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void test() {
        Device device = Device.preferredDevice();
        device.setDefaultDevice();
        var enet = new EfficientNet(EfficientNet.V2S, 0.5);
        System.out.println(enet);
        var model = new Model(enet);
        model.load("deep/src/universal/models/efficientnet_v2_s.pt");
        Tensor example = Tensor.rand(1, 3, 384, 384);
        Tensor output = model.forward(example);
    }
}