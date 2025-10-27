package com.model;
public abstract class DataConstants {
    //Files
    protected static final String USER_TEMP_FILE_NAME = "json/temp.json";
    protected static final String ROOM_TEMP_FILE_NAME = "json/tempRoom.json";
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
    protected static final String ROOM_ROOM = "room";

    //Room Progess Room 
    protected static final String ROOM_PROGRESS_ROOM_NAME = "roomName";
    protected static final String ROOM_PROGRESS_ROOM_TYPE = "type";
    protected static final String ROOM_PROGRESS_ROOM_SOLVED = "solved";
    protected static final String ROOM_PROGERSS_ROOM_PUZZLE = "puzzles";
    protected static final String ROOM_PROGRESS_ROOM_ITEMS = "items";
    protected static final String ROOM_OBJECTS = "objects";

    //Puzzle Progress
    protected static final String PUZZLE_PROGRESS_COMPLETED = "puzzleComplete";
    protected static final String PUZZLE_PROGRESS_TIME = "puzzleTime";
    protected static final String PUZZLE_HINTS_USED = "numhintsUsed";
    protected static final String PUZZLE_PROGRESS_PUZZLE = "puzzle";

    //Puzzle Progress puzzle
    protected static String PUZZLE_TYPE = "type";
    protected static String PUZZLE_ANSWER = "answer";
    protected static String PUZZLE_HINTS = "hints";
    protected static String PUZZLE_PUZZLE_NUM = "puzzleNum";

    //Riddle
    protected static String PUZZLE_RIDDLE = "riddle";

    //Cipher
    protected static String CIPHER_ANAGRAM = "anagram";
    protected static String CIPHER_CEASER = "ceasarCiphers";

    //Object
    protected static String OBJECT_DESCRIPTION = "objectDescription";
    protected static String OBJECT_CONTAINS = "contains";
    protected static String OBJECT_NAME = "objectName";

    //Hint
    protected static String HINTS = "hint";

    //Time
    protected static final String TIME = "minTime";

    //Room
    protected static final String ROOM_ROOM_NAME = "roomName";
    protected static final String ROOM_ROOM_TYPE = "type";
    protected static final String ROOM_SOLVED = "solved";
    protected static final String PUZZLE_ARRAY = "puzzles";
    protected static final String ITEM_ARRAY = "items";
    protected static final String ROOM_DESCRIPTION = "roomDescription";
    protected static final String ROOM_OPTIONS = "options";

    //puzzles
    protected static final String PUZZLE_SOLUTION = "solution";
    protected static final String PUZZLE_NUM = "puzzleNum";

    //shared between the different puzzles
    protected static final String PUZZLE_HINT = "hint";
    
    //Riddle Puzzle
    protected static final String RIDDLE_RIDDLE = "riddle";

    //Item puzzle
    protected static final String ITEM_PUZZLE_ARRAY = "requiredItems";

    //Items
    protected static final String ITEM_NAME = "name";
    protected static final String ITEM_DESCRIPTION = "description";
    
}
