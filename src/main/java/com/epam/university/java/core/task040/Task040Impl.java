package com.epam.university.java.core.task040;

public class Task040Impl implements Task040 {

    /**
     * Count the score of Ten-Pin Bowling game.
     * Tip: read the rules of game
     *
     * @param str representing a player's ten frames. Frames separated by " ".
     *            Each frame is two characters (shots) - digits or 'X' or '/'.
     *            'X' - means "strike", '/' - means spare.
     * @return total score of player.
     */
    @Override
    public int countScore(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        int score = 0;
        String[] frames = str.split(" ");
        //only pins score without bonuses
        for (int i = 0; i < frames.length; i++) {
            score += pinsScore(frames[i]);
        }
        score += bonusScore(frames);
        //TODO: count bonus score and add it to total score (implement bonus score method)
        return score;
    }

    private int pinsScore(String frame) {
        if (frame.charAt(0) == 'X') {
            return 10;
        } else if (frame.charAt(1) == '/') {
            return 10;
        }   else {
            return Integer.parseInt(Character.toString(frame.charAt(0)))
                    + Integer.parseInt(Character.toString(frame.charAt(1)));
        }
    }

    private int bonusScore(String[] frames) {
        int bonus = 0;
        // counts bonus for first seven frames
        for (int i = 0; i < frames.length - 3; i++) {
            if (frames[i].charAt(0) == 'X') {
                if (frames[i + 1].charAt(0) == 'X') {
                    bonus += 10;
                    if (frames[i + 2].charAt(0) == 'X') {
                        bonus += 10;
                    } else {
                        bonus += Integer.parseInt(Character.toString(frames[i + 2].charAt(0)));
                    }
                } else {
                    bonus += pinsScore(frames[i + 1]);
                }
            } else if (frames[i].charAt(1) == '/') {
                if (frames[i + 1].charAt(0) == 'X') {
                    bonus += 10;
                } else {
                    bonus += Integer.parseInt(Character.toString(frames[i + 1].charAt(0)));
                }
            }
        }
        String frame8 = frames[7];
        String frame9 = frames[8];
        String frame10 = frames[9];
        //bonus for frame 8
        if (frame8.charAt(0) == 'X') {
            if (frame9.charAt(0) == 'X') {
                bonus += pinsScore(frame9);
                if (frame10.charAt(0) == 'X') {
                    bonus += 10;
                } else {
                    bonus += Integer.parseInt(Character.toString(frame10.charAt(0)));
                }

            } else if (frame9.charAt(1) == '/') {
                bonus += 10;
            } else {
                bonus += Integer.parseInt(Character.toString(frame9.charAt(0)))
                        + Integer.parseInt(Character.toString(frame9.charAt(1)));
            }
        } else if (frame8.charAt(1) == '/') {
            if (frame9.charAt(0) == 'X') {
                bonus += 10;
            } else {
                bonus += Integer.parseInt(Character.toString(frame9.charAt(0)));
            }
        }
        //bonus for frame 9
        if (frame9.charAt(0) == 'X') {
            if (frame10.charAt(0) == 'X' && frame10.charAt(1) == 'X') {
                bonus += 20;
            } else if (frame10.charAt(0) == 'X') {
                bonus += 10;
                bonus += Integer.parseInt(Character.toString(frame10.charAt(1)));
            } else {
                bonus += Integer.parseInt(Character.toString(frame10.charAt(0)))
                        + Integer.parseInt(Character.toString(frame10.charAt(1)));
            }
        } else if (frame9.charAt(1) == '/') {
            if (frame10.charAt(0) == 'X') {
                bonus += 10;
            } else {
                bonus += Integer.parseInt(Character.toString(frame10.charAt(0)));
            }
        }
        //bonus for frame 10
        if (frame10.charAt(0) == 'X' && frame10.charAt(1) == 'X' && frame10.charAt(1) == 'X') {
            bonus += 20;
        } else if (frame10.charAt(0) == 'X' && frame10.charAt(1) == 'X') {
            bonus += 10;
            bonus += Integer.parseInt(Character.toString(frame10.charAt(2)));
        } else if (frame10.charAt(0) == 'X') {
            bonus += Integer.parseInt(Character.toString(frame10.charAt(1)))
                    + Integer.parseInt(Character.toString(frame10.charAt(2)));
        } else if (frame10.charAt(1) == '/') {
            bonus += Integer.parseInt(Character.toString(frame10.charAt(2)));
        }
        return bonus;
    }
}
