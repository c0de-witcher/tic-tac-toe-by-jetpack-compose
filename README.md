Tic-Tac-Toe Compose Game
This project implements a Tic-Tac-Toe game using Jetpack Compose for Android development.

Overview
The Tic-Tac-Toe game includes the following features:

Two-player functionality (Player 1 vs Player 2)
Visual indicators for current player's turn
Reset button to restart the game
Win detection logic to determine the winner
UI designed using Jetpack Compose components like Box, Column, Row, Text, Button, Icon, and custom Canvas drawings for X and O marks.
Key Components
screen()
Entry point for the Composable function.
Manages game state, including the game board (buttonBoard), current turn (turn), win condition (check), and winner display (winner).
win_player_Box()
Displays the current winner and provides a button to restart the game.
app_name() and user_turn()
Display the game title and indicate which player's turn it is.
box_base()
Draws the Tic-Tac-Toe grid using Canvas.
Handles button clicks and updates the game board (buttonBoard).
game_design()
Combines various UI components to form the game board and surrounding layout.
Coss() and circle()
Custom Composables for drawing X and O marks using Canvas.
winercount()
Function to check for a winning condition by examining rows, columns, and diagonals of the game board.
Preview
The view() function provides a preview of the entire game screen layout.

Dependencies
AndroidX Jetpack Compose
Kotlin Coroutines for asynchronous operations (used for restarting the game delay)
Android Studio with Compose support
How to Use
Clone the repository.
Open the project in Android Studio.
Build and run the project on an Android emulator or device.
Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.
![Screenshot_2024-07-24-05-45-11-70_1d428ad542c5b8314a6e5e21fd19d69b](https://github.com/user-attachments/assets/81912803-8fd4-4ca2-b8c6-d526d5d924f4)
![Screenshot_2024-07-24-05-45-01-98_1d428ad542c5b8314a6e5e21fd19d69b](https://github.com/user-attachments/assets/254e26dc-57ee-403a-9106-c65fc262e0e3)
![Screenshot_2024-07-24-05-44-54-48_1d428ad542c5b8314a6e5e21fd19d69b](https://github.com/user-attachments/assets/5bbd3148-3162-41c2-b364-f62be6da965b)
