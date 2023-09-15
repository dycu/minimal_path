# Minimum/Maximum triangle path

The solution to this problem is widely known and my first assumption was that the
default recursive solution would fail for bigger inputs. Then I followed
the tail recursive solution that going from the bottom up calculates intermidiate
steps to remember which path it should follow going back (memoization).

It probably could be simplified to collect all the data while going up, without the
intermidiate step of collecting the `Path` and to follow it to collect the exact
values from the nodes. But this way it seemed easier to implement and to be
more readable than having it done in one go. The most difficult part, performance
wise, is while we're looking for the path, not getting the values, anyway.

## Run application

```shell
sbt run

And then provide the file name, e.g.:
input
```

## Run tests

```shell
sbt test
```

