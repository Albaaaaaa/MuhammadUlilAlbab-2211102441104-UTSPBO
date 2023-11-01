import greenfoot.*;  

public class MyWorld extends World {
    public boolean GAMEOVER = false;
    private int mscore = 0;
    private Score score;

    public MyWorld() {
        super(990, 599, 1, false);

        Head head = new Head();
        addObject(head, 100, 200);

        Snake snake = new Snake();
        addObject(snake, head.getX() - Snake.delta, head.getY());
        snake.snake = head;

        addFood();
        addTrap();

        for (int i = 0; i < getWidth(); i += Snake.delta) {
            addObject(new Wall(), i, 0);
            addObject(new Wall(), i, getHeight() - Snake.delta);
        }
        for (int i = 0; i < getHeight(); i += Snake.delta) {
            addObject(new Wall(), 0, i);
            addObject(new Wall(), getWidth() - Snake.delta, i);
        }

        score = new Score();
        score.setScore(mscore);
        addObject(score, getWidth() - 50, 25);
        prepare();
    }

    public void addFood() {
        addObject(new Food(), Greenfoot.getRandomNumber(getWidth() / Snake.delta) * Snake.delta, Greenfoot.getRandomNumber(getHeight() / Snake.delta) * Snake.delta);
    }

    public void addTrap() {
        addObject(new Trap(), Greenfoot.getRandomNumber(getWidth() / Snake.delta) * Snake.delta, Greenfoot.getRandomNumber(getHeight() / Snake.delta) * Snake.delta);
    }

    public void setScore(int a) {
        mscore += a;
        score.setScore(mscore);
    }

    public void act() {
        checkGameOver();
    }

    private void checkGameOver() {
        Head head = getObjects(Head.class).get(0);
        if (head.getX() <= 0 || head.getX() >= getWidth() - Snake.delta || head.getY() <= 0 || head.getY() >= getHeight() - Snake.delta) {
            showGameOver();
        }
    }

    private void showGameOver() {
        addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
        GAMEOVER = true;

        if (Greenfoot.isKeyDown("space")) {
            removeObjects(getObjects(GameOver.class));

            GAMEOVER = false;
            mscore = 0;
            score.setScore(mscore);

            removeObjects(getObjects(Snake.class));
            removeObjects(getObjects(Food.class));
            removeObjects(getObjects(Trap.class));

            Head newHead = new Head();
            addObject(newHead, 100, 200);
            Snake newSnake = new Snake();
            addObject(newSnake, newHead.getX() - Snake.delta, newHead.getY());
            newSnake.snake = newHead;
            addFood();
            addTrap();
        }
    }

    private void prepare() {
        Trap trap = new Trap();
        addObject(trap, 664, 185);
        trap.setLocation(660, 184);
        trap.setLocation(766,285);
    }
}

