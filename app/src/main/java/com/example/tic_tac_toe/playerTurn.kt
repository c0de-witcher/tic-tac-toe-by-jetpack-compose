package com.example.tic_tac_toe

data class playerTurn(
    val player1:Int = 1,
    val player2:Int= 2,
    val currentTurn: BoardcellValue = BoardcellValue.Cross,
    val vicoty_type: victoryType = victoryType.None
)

enum class BoardcellValue{
    Circle,
    Cross,
    None

}
enum class victoryType{
    win_row1,
    win_row2,
    win_row3,
    win_column1,
    win_column2,
    win_column3,
    win_right,
    win_left,
    None
}
