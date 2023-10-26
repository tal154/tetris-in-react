# Tetris-in-react using Vite and typescript

# setup 
> npm install vite
>
to install vite

# run
in terminal execute
> vite
> 
to start vite+react front end

# Schedule:

Create vite project, scaffolding - 20 mins

Create components - 30 mins

Create styling - 30 mins

Create board - 60 mins

Create game logic - 1.5 hours

Display single piece -  1 hour

Collision detection - 30 mins

Rotate piece - 45 mins

Collision and rotation interaction - 1 hour

Render multiple pieces - 60 mins

Custom hooks - 90 mins

Refactor for routes - 15 mins

Create Nav component - 10 mins

Nav component logic -  1 hour

Scores view - 2 hours

Backend - 3 hours

Tests - 2 hours

Connect Backend to Frontend - 2 hours

Final CSS - 3 hours

Total: 23 hours 

## 1. Problem Statement

This project is a working Tetris game built with React that utilizes SQL to store users and scores.

## 2. Technical Solution

> This application will be a working Tetris game that will keep user scores and order them in a descending list. 
> 
> ### Scenario 1
> A player can play a game of Tetris and ~~have their score recorded. Each time a new high score is earned, then their current recorded score is replaced.~~
> 
> ### Scenario 2
> ~~An admin will have the authorization to remove scores.~~

## 3. Glossary

> ### Game
> The game field will be a game of Tetris, which includes the game board and the score.
> ### Player
> Anyone who plays the game. A player does not have to be a user.
> ### User
> A user has an account that lets them keep track of their score.
> ### Admin
> ~~A user with an administrator role. They have more privileged applications, letting them update and delete scores.~~
> ### Score
> A user's stored game score

## 4. High-Level Requirement

Briefly describe what each user role/authority can do. (These are user stories.)

> - Play a game (anyone).
> - ~~Remove a score (ADMIN).~~ now a stretch goal
> - Browse scores (anyone).

## 5. User Stories/Scenarios

Elaborate use stories.

> ### Play a game
> 
> The player plays a game.
> 
> 
> **Precondition**: none
> 
> **Post-condition**: If the player is a USER, the run is automatically saved.
> 
> ### Remove a Run, now a stretch goal
> 
> Can remove a score.
> 
> **Precondition**: The user must be logged in with the ADMIN role.
> 
> **Post-condition**: none
> 
> ### Browse Runs
> 
> Decide how to display runs to anyone who uses the application.
> 
> - Text-based: Scores are listed descending on a score page. Can show the user's personal score separately.
> 
> **Precondition**: None
> 
> **Post-condition**: None
