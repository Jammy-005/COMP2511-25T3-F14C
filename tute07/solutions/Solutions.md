# Tutorial 07
## A. Singleton Pattern & Concurrency
Consider the Bank Account class from Lab 04. What if multiple people try to access the bank account at the same time? Inside `src/heist` are three classes:

- `BankAccount`, from Lab 04.
- `BankAccountAccessor`. Objects of this type are an instance of an access to a bank account to withdraw money a given number of times by given amounts.
- `BankAccountThreadedAccessor`, which `extends Thread`, and overrides the method `run` to create a new instance of `BankAccountAccessor` and access the bank.

Currently when you run the code, you will find that each thread accesses the bank at the same time (which doesn't make sense). Most of the time this just means that each accessor tries to make as many transactions as they can before the bank runs out of money:

```
The balance is: $100
Rio is accessing the bank.
Denver is accessing the bank.
Tokyo is accessing the bank.
Tokyo successfully withdrew $6
Denver successfully withdrew $49
Rio successfully withdrew $20
Tokyo successfully withdrew $6
Denver failed to withdraw $49.
Rio failed to withdraw $20.
Tokyo successfully withdrew $6
Rio failed to withdraw $20.
Denver is leaving the bank, the balance is $13
Tokyo successfully withdrew $6
Rio failed to withdraw $20.
Tokyo successfully withdrew $6
Rio failed to withdraw $20.
Tokyo failed to withdraw $6.
Rio is leaving the bank, the balance is $1
Tokyo is leaving the bank, the balance is $1
```

In some cases though, some strange behaviour is produced by this **race condition**:

```
Denver is accessing the bank.
Tokyo is accessing the bank.
The final balance is: $100
Rio is accessing the bank.
Rio successfully withdrew $20
Tokyo successfully withdrew $6
Denver successfully withdrew $49
Tokyo successfully withdrew $6
Denver failed to withdraw $49.
Rio successfully withdrew $20
Rio failed to withdraw $20.
Denver is leaving the bank, the balance is -1
Tokyo failed to withdraw $6.
Rio failed to withdraw $20.
Tokyo failed to withdraw $6.
Rio failed to withdraw $20.
Tokyo failed to withdraw $6.
Tokyo failed to withdraw $6.
Rio is leaving the bank, the balance is -1
Tokyo is leaving the bank, the balance is -1
```

Use the Singleton Pattern to ensure that only one person can access the bank at a time. You can assume for simplicity's sake that only one access to *any* bank account can ever be made at a given time.
> See [solutions/src/heist](solutions/src/heist/)

## B. Abstract Factory Pattern

In tutorial 04, we discussed the factory pattern. We'll now look at a slightly modified scenario where the **abstract factory pattern** is more appropriate

The original spec is as follows:

> Inside `src/thrones`, there is some code to model a simple chess-like game. In this game different types of characters move around on a grid fighting each other. When one character moves into the square occupied by another they attack that character and inflict damage based on random chance. There are four types of characters:
>
> - A king can move one square in any direction (including diagonally), and always causes 8 points of damage when attacking.
> - A knight can move like a knight in chess (in an L shape), and has a 1 in 2 chance of inflicting 10 points of damage when attacking.
> - A queen can move to any square in the same column, row or diagonal as she is currently on, and has a 1 in 3 chance of inflicting 12 points of damage and a 2 out of 3 chance of inflicting 6 points of damage.
> - A dragon can only move up, down, left or right, and has a 1 in 6 chance of inflicting 20 points of damage.

We now want to simulate the board game with the added change that pieces can be made from different materials, either Wood, Plastic or Metal. We want to be able to pick and choose which material we create a board with. Each material has its own construction requirements:
- Metal pieces are heavy and hence can only be set with `0 <= x <= 5`, and `y = 0`
- Plastic pieces are lightweight and can be placed anywhere within a given `bound` (provided to the factory)
- Wooden pieces are large and bulky, and take up a `n`x`n` grid, meaning they can only be placed on tiles with `x` and `y` values which divide `n` (`n` is provided to the factory)

Utilise the Abstract Factory pattern to solve these requirements.

**For this exercise, we can ignore the decorators present in the starter code - those will come in Part C.**
> See [solutions/src/thrones](solutions/src/thrones/)

## C. Evolution of Requirements

This exercise continues on from part B.

Suppose a requirements change was introduced that necessitated support for any character to wear different sorts of armour.

- A helmet reduces the amount of damage inflicted upon a character by 1 point.
- Chain mail reduces the amount of damage by half (rounded down).
- A chest plate caps the amount of damage to 7, but also slows the character down. If the character is otherwise capable of moving more than one square at a time then this armour restricts each move to distances of 3 squares or less (by manhattan distance).

Use the Decorator Pattern to realise these new requirements. Assume that, as this game takes place in a virtual world, there are no restrictions on the number of pieces of armour a character can wear and that the "order" in which armour is worn affects how it works. You may need to make a small change to the existing code.
> See [solutions/src/thrones](solutions/src/thrones/)
