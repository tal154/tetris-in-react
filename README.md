# tetris-in-react

## 1. Problem Statement

This project is a working tetris game built with React that utililzes SQL to store users and scores.

## 2. Technical Solution

> This application will be a working tetris game that will keep user scores and order them in a descending list. 
> 
> ### Scenario 1
> A player can play a game of tetris and have their score recorded. Each time a new high score is earned, then their current recorded score is replace.
> 
> ### Scenario 2
> An admin will have the authorization to remove scores.

## 3. Glossary

> ### Game
> The game field will be a game of tetris, which includes the game board and the score.
> ### Player
> Anyone who plays the game. A player does not have to be a user.
> ### User
> A user has an account that lets them keep track of their score.
> ### Admin
> A user with an administrator role. They have more privileges applications, letting them update and delete scores.
> ### Score
> A users stored game score

## 4. High Level Requirement

Briefly describe what each user role/authority can do. (These are user stories.)

> - Play a game (anyone).
> - Remove a score (ADMIN).
> - Browse scores (anyone).

## 5. User Stories/Scenarios

Elaborate use stories.

> ### Play a game
> 
> Player plays a game.
> 
> **Precondition**: none
> 
> **Post-condition**: If the player is a USER, the run is automatically saved.
> 
> ### Remove a Run
> 
> Can remove a score.
> 
> **Precondition**: User must be logged in with the ADMIN role.
> 
> **Post-condition**: none
> 
> ### Browse Runs
> 
> Decide how to display runs to anyone who uses the application.
> 
> - Text-based: Scores are listed descending on a score page. Can show user's personal score separated.
> 
> **Precondition**: None
> 
> **Post-condition**: None
