package edu.projects.project1.Game.status;

public enum GameStatus implements Status {

    WIN {

        @Override
        public boolean isEndGame() {
            return true;
        }

        @Override
        public String getMessage() {
            return "You win!";
        }
    },
    DEFEAT {

        @Override
        public boolean isEndGame() {
            return true;
        }

        @Override
        public String getMessage() {
            return "You lost!";
        }
    },
    PLAYING {

        @Override
        public boolean isEndGame() {
            return false;
        }

        @Override
        public String getMessage() {
            return "";
        }
    }
}
