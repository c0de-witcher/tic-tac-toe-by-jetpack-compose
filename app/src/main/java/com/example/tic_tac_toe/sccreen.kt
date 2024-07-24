package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import android.widget.Toast
import androidx.annotation.FloatRange
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTargetMarker
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tic_tac_toe.ui.theme.Pink40
import com.example.tic_tac_toe.ui.theme.Pink80
import com.example.tic_tac_toe.ui.theme.Purple40
import com.example.tic_tac_toe.ui.theme.Purple80
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.math.sign

val player1 = 1
val player2 = 2;


@SuppressLint("UnrememberedMutableState")
@Composable
fun screen(){
    var buttonBoard = remember {
        mutableStateOf(Array(3){ Array<String?>(3) {null} })
    }


    var turn = remember {
        mutableStateOf(player1)
    }
    var check : MutableState<String?> = remember {
        mutableStateOf(null)
    }
    var winner : MutableState<String?> = remember {
        mutableStateOf("")
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Purple40)
        ){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()) {
            app_name()
            user_turn(turn)
            game_design(turn,{},buttonBoard, check,winner)
            win_player_Box(turn,buttonBoard,check,winner)






        }

    }

}


@Composable
fun win_player_Box(turn: MutableState<Int>,buttonBoard: MutableState<Array<Array<String?>>>,check: MutableState<String?>,winner: MutableState<String?>){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
       modifier = Modifier
           .padding(0.dp, 40.dp, 0.dp, 0.dp)
           .fillMaxWidth()){
        Box {
            Row {
                Text(text = "Win : ",
                    color = Color.Green,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)

                Text(text ="${winner.value}",
                    color = Color.Yellow,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)

            }

        }


        Button(onClick = {buttonBoard.value = Array(3) { Array<String?>(3) { null } }
                         turn.value = player1
                         check.value = null
                         winner.value = ""},
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(
                    2.dp, Color.Yellow,
                    RoundedCornerShape(20.dp)
                )
            ) {
            Text(text = "Restart")
        }
            
        }
    }



@Composable
fun app_name(){
    Text(text = "Tic-Tac-Toe",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))
}

@Composable
fun user_turn(turn: MutableState<Int>){

   Row (modifier = Modifier
       .fillMaxWidth()
       .padding(70.dp, 50.dp, 70.dp, 0.dp),
       horizontalArrangement = Arrangement.SpaceBetween){
       if (turn.value == player1){
           Box(modifier = Modifier
               .clip(RoundedCornerShape(10.dp))
               .border(2.dp, Color.White, RoundedCornerShape(10.dp))
               .size(60.dp)
               .aspectRatio(1f)){
               Coss()
           }
           Box(modifier = Modifier
               .size(60.dp)
               .aspectRatio(1f)
               .clip(RoundedCornerShape(10.dp))
               .border(2.dp, Color.Transparent, RoundedCornerShape(10.dp))){
               circle()
           }


       }
       else{
           Box(modifier = Modifier
               .clip(RoundedCornerShape(10.dp))
               .border(2.dp, Color.Transparent, RoundedCornerShape(10.dp))
               .size(60.dp)
               .aspectRatio(1f)){
               Coss()
           }
           Box(modifier = Modifier
               .size(60.dp)
               .aspectRatio(1f)
               .clip(RoundedCornerShape(10.dp))
               .border(2.dp, Color.White, RoundedCornerShape(10.dp))){
               circle()
           }

       }



   }

}






@SuppressLint("UnrememberedMutableState")
@Composable
fun box_base(turn: MutableState<Int>,click:()-> Unit,buttonBoard: MutableState<Array<Array<String?>>>,check:MutableState<String?>,winner: MutableState<String?>){



       androidx.compose.foundation.Canvas(modifier = Modifier
           .padding(20.dp)
           .size(300.dp)){

           drawLine(Color.White,
               strokeWidth = 10f,
               alpha = 1f,
               cap = StrokeCap.Round,
               start = Offset(size.width*1/3,0f),
               end = Offset(size.width*1/3,size.height),
           )

           drawLine(Color.White,
               strokeWidth = 10f,
               alpha = 1f,
               cap = StrokeCap.Round,
               start = Offset(size.width*2/3,0f),
               end = Offset(size.width*2/3,size.height),
           )

           drawLine(Color.White,
               strokeWidth = 10f,
               alpha = 1f,
               cap = StrokeCap.Round,
               start = Offset(0f,size.height*1/3),
               end = Offset(size.width,size.height*1/3),
           )

           drawLine(Color.White,
               strokeWidth = 10f,
               alpha = 1f,
               cap = StrokeCap.Round,
               start = Offset(0f,size.height*2/3),
               end = Offset(size.width,size.height*2/3),
           )


   }






    Column (modifier = Modifier
        .size(300.dp)
        .padding(10.dp)){
        for(i in 0..2){
            Row (modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                for (j in 0..2){
                    Button(onClick = {

                        if(buttonBoard.value[i][j]==null && turn.value== player1){

                            turn.value= player2
                            buttonBoard.value = buttonBoard.value.copyOf() // Correct: Update using setter
                            buttonBoard.value[i][j] = "x"
                            Log.i("shivam","${buttonBoard.value[i][j]} player1")
                            check.value = winercount(buttonBoard)

                        }
                        else if (buttonBoard.value[i][j]==null && turn.value== player2){

                            buttonBoard.value = buttonBoard.value.copyOf() // Correct: Update using setter
                            buttonBoard.value[i][j] = "o"
                            turn.value = player1
                            Log.i("shivam","${buttonBoard.value[i][j]} player2")
                            check.value = winercount(buttonBoard)
                        }
                                     click()},
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                        when (buttonBoard.value[i][j]) {
                            "x" -> Icon(Icons.Filled.Clear, contentDescription = "X")
                            "o" -> Icon(Icons.Filled.FavoriteBorder, contentDescription = "O")
                            else -> {} // Handle other cases if needed
                        }





                    }
                }

            }
        }
    }
    if(check.value!=null){
        winner.value = if (check.value=="x") "Player 1" else "Player 2"

        Log.i("shivam ", " check value")
        Box(modifier = Modifier
            .background(Pink80, RoundedCornerShape(20.dp))
            .border(
                2.dp, Color.Black,
                RoundedCornerShape(20.dp)
            )
            .size(300.dp),
            contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.winner), contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(200.dp)
                        .fillMaxWidth()

                )

                Text(text = if (check.value=="x") "Player1" else "Player 2",
                    modifier = Modifier.padding(20.dp),
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold)
            }

        }
        turn.value = player1


    }



}

fun winercount(buttonBoard: MutableState<Array<Array<String?>>>) : String?{
    Log.i("shivam ","winner count")
    //for row
    for (i in 0..2){
         if(buttonBoard.value[i][0]!=null && buttonBoard.value[i][0] == buttonBoard.value[i][1] && buttonBoard.value[i][1] == buttonBoard.value[i][2] ) {

             return buttonBoard.value[i][0]
         }
    }

    //for column
    for (col in 0..2){
        if(buttonBoard.value[0][col]!=null && buttonBoard.value[0][col] == buttonBoard.value[1][col] && buttonBoard.value[1][col] == buttonBoard.value[2][col] ){

            return buttonBoard.value[0][col]
        }
    }
    if (buttonBoard.value[0][0]!=null  && buttonBoard.value[0][0]==buttonBoard.value[1][1] && buttonBoard.value[2][2] == buttonBoard.value[1][1]){

        return buttonBoard.value[0][0]
    }

    if (buttonBoard.value[0][2]!=null && buttonBoard.value[0][2]==buttonBoard.value[1][1] && buttonBoard.value[2][0] == buttonBoard.value[1][1]){

        return  buttonBoard.value[0][2]
    }

    return  null

}




@Composable
fun Coss(){

        androidx.compose.foundation.Canvas(modifier = Modifier
            .size(60.dp)
            .padding(10.dp)) {
            drawLine(color = Color.White,
                start = Offset(0f,0f),
                end = Offset(size.width,size.height),
                strokeWidth = 10f,
                cap = StrokeCap.Round
            )
            drawLine(color = Color.White,
                start = Offset(size.width,0f),
                end = Offset(0f,size.width),
                strokeWidth = 10f,
                cap = StrokeCap.Round
            )


            
        }

}

@Composable
fun circle(){

        androidx.compose.foundation.Canvas(modifier = Modifier
            .size(60.dp)
            .padding(10.dp)) {
            drawCircle(
                color = Color.White,
                style = Stroke(10f)


            )
            
        }

}

@Composable
fun game_design(turn:MutableState<Int>, click: () -> Unit, buttonBoard: MutableState<Array<Array<String?>>>, check : MutableState<String?>, winner: MutableState<String?>){


           Box (modifier = Modifier
               .padding(0.dp, 130.dp, 0.dp, 0.dp)
               .clip(RoundedCornerShape(10.dp))
               .background(Color.Transparent)
               .size(300.dp)
               .aspectRatio(1f)
               .shadow(
                   elevation = 3.dp,
                   shape = RoundedCornerShape(10.dp),
                   spotColor = Color.White

               )){
               box_base(turn,click,buttonBoard,check,winner)
           }




    }




@Preview
@Composable
private fun view() {
    screen()


}