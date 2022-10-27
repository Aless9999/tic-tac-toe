/*
 * Copyright (c) 2022. http://macnonline
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package macnonline.tic_tac_toe;

import macnonline.tic_tac_toe.components.Game;
import macnonline.tic_tac_toe.components.GameFactory;

/**
 * @author macnonline
 */
public final class Launcher {
    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory(args);
        Game game = (gameFactory.creat());


        game.play();
    }
}
