# Play2 Twitter Bootstrap 3 template helper

This is a collection of template helpers for twitter bootstrap 3 (http://getbootstrap.com/), which i wrote.


## Versions
* 2.4.0: Release for play 2.4
* 1.0:  Release for play 2.3.


0.4: Fixed bug with class is rendered out twice when using 'class->"test", added bsSelected for http://silviomoreto.github.io/bootstrap-select/ support.

0.3: Added inputNumberSpinner to formhelpers and removed _hideInfo because play already brings the _showConstraints option

0.2: Release for play 2.2.3 and added linkButtonHelpers

## Installation (using sbt)

You will need to add the following resolver in your `project/Build.scala` file:

```scala
resolvers += "tuxburner.github.io" at "http://tuxburner.github.io/repo"
```

Add a dependency on the following artifact:

```scala
libraryDependencies += "com.github.tuxBurner" %% "play-twbs3" % "2.4.0"
```

## Examples
I wrote an example project for the helpers, which shows how to use them in your project.

Take a look at: example-play-app

## Help:
If you have any ideas how to make it better, or you are missing any features, pull requests are always welcome :)
