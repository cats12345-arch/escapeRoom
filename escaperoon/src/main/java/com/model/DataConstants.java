package com.model;
public abstract class DataConstants {
    protected static final String USER_TEMP_FILE_NAME = "json/temp.json";
    protected static final String USER_FILE_NAME = "json/account.json";
    protected static final String ROOM_FILE_NAME = "json/rooms.json";

    //Accounts-will be part of players later after testing is done
    protected static final String ACCOUNT_USER_NAME = "username";
    protected static final String ACCOUNT_PASSWORD = "password";
    protected static final String ACCOUNT_SCORE = "score";
    protected static final String ACCOUNT_ACHIEVEMENT = "achievement";
    protected static final String ACCOUNT_ROOM_PROGRESS = "roomProgress";

    //Achievement
    protected static final String ACHIEVEMENT_NAME = "name";
    protected static final String ACHIEVEMENT_AWARDED = "awarded";
    protected static final String ACHIEVEMENT_DESCRIPTION = "description";

    //Room Progress
    protected static final String ROOM_PROGRESS_ITEMS = "items";
    protected static final String ROOM_PUZZLE_PROGRESS = "puzzleProgress";
    protected static final String ROOM_PROGRESS_COMPLETED = "roomComplete";
    protected static final String ROOM_PROGRESS_TIME = "roomTime";

    //Puzzle Progress
    protected static final String PUZZLE_PROGRESS_COMPLETED = "puzzleComplete";
    protected static final String PUZZLE_PROGRESS_TIME = "puzzleTime";
    protected static final String PUZZLE_HINTS_USED = "numhintsUsed";

    //Time
    protected static final String TIME = "minTime";

    //Room
    protected static final String ROOM_ROOM_NAME = "roomName";
    protected static final String ROOM_ROOM_TYPE = "type";
    protected static final String PUZZLE_ARRAY = "puzzles";
    protected static final String ITEM_ARRAY = "items";

    //puzzles
    protected static final String PUZZLE_SOLUTION = "solution";
    protected static final String PUZZLE_NUM = "puzzleNum";
    protected static final String RIDDLE_PUZZLE_ARRAY = "riddlePuzzle";
    protected static final String CIPHER_PUZZLE_ARRAY = "cipherPuzzle";
    protected static final String ITEM_PUZZLE_ARRAY = "itemPuzzle";

    //shared between the different puzzles
    protected static final String PUZZLE_HINT = "hint";
    
    //Riddle Puzzle
    protected static final String RIDDLE_RIDDLE = "riddle";

    //Items
    protected static final String ITEM_NAME = "name";
    protected static final String ITEM_DESCRIPTION = "description";
    
}
