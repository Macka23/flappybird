package com.example.flappybird.Views

import android.content.Intent
import android.os.SystemClock
import com.example.flappybird.Activities.GameOverActivity
import com.example.flappybird.Constants.Constants
import com.example.flappybird.GameObjects.AllObjects
import com.example.flappybird.GameStateManager


class GameRun(private val allObjects: AllObjects) {
    private var previousFrameTime: Long = 0
    private var gameMode : PipeType = PipeType.STATIC
    private val stateManager = GameStateManager()

    fun run(){
        val currentTime = System.currentTimeMillis()
        val elapsedTimeMS: Double = (currentTime - previousFrameTime).toDouble()

        if (elapsedTimeMS > 10){
            for (pipe in allObjects.ListOfPipes) {
                pipe.update(0)
            }
            previousFrameTime = currentTime
        }

        if (SystemClock.currentThreadTimeMillis() > 100) {
            allObjects.bird.update(elapsedTimeMS.toInt())
        }
        if (gameMode == PipeType.STATIC || gameMode == PipeType.MOVING) {
            if (allObjects.ListOfPipes.last().Xpos < allObjects.bird.x) {
                createPipe()
                allObjects.score.update(0)
            }


            if (allObjects.ListOfPipes.first().Xpos + allObjects.ListOfPipes.first().width < 0) {
                allObjects.ListOfPipes.removeAt(0)
            }
        }
        else if (gameMode == PipeType.BLOC) {
            if (allObjects.ListOfPipes.last().Ypos > allObjects.bird.y) {
                createPipe()
                allObjects.score.update(elapsedTimeMS.toInt())
            }
            if (allObjects.ListOfPipes.first().Ypos + allObjects.ListOfPipes.first().width > Constants.screenHeight) {
                allObjects.ListOfPipes.removeAt(0)
            }
        }

        if (returnEndGame()){
            gameOver()
        }
    }

    fun setTime() {
        previousFrameTime = SystemClock.uptimeMillis()
    }

    private fun gameOver(){
        allObjects.score.notifyGameOver()
        val intent = Intent(allObjects.context, GameOverActivity::class.java)
        intent.putExtra("score", allObjects.score.yourScore)
        allObjects.context.startActivity(intent)
    }

    private fun returnEndGame(): Boolean {
        for (pipe in allObjects.ListOfPipes){
            if (allObjects.bird.returnCollision(pipe)){
                return true
            }
        }
        return false
    }

    private fun createPipe(){
        stateManager.updateState(allObjects.score.yourScore)
        val pipeType = stateManager.getPipeType()
        allObjects.ListOfPipes.add(PipeFactory.createPipe(pipeType))
    }

}