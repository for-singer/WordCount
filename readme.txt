Given a text file on local file system, write a java program which counts unique words in the file. The file may contain multiple lines. The words in a line may be split by whitespace, comma or dot (“.”)
There must be unit tests written at least for the method doing all the math.

Program input params:
1.       path to the file
2.       integer number N which indicates the amount of words to output
Expected output:
·         “word – count”  pairs ordered by count in descending order.
·         Exactly N pairs printed out if the amount of unique words is greater or equal to N; all pairs printed out otherwise.
·         if there are more than one word with the same frequency, the words must be ordered alphabetically within corresponding group.

E.g.:
When I run
$ java wordCount lyrics.txt 5

The expected output should be:
merry=16
christmas=8
their=8
to=8
good=6



Lyrics.txt file content (Carol Of The Bells Lyrics) :

Hark. How the bells, sweet silver bells
All seem to say, Throw cares away.
Christmas is here, bringing good cheer
To young and old, meek and the bold
Ding, dong, ding, dong, that is their song,
With joyful ring, all caroling
One seems to hear words of good cheer
From everywhere, filling the air
Oh, how they pound, raising their sound
Over hill and dale, telling their tale

Gaily they ring, while people sing
Songs of good cheer, Christmas is here.
Merry, merry, merry, merry Christmas.
Merry, merry, merry, merry Christmas.

On, on they send, on without end
Their joyful tone to every home
Hark. How the bells, sweet silver bells
All seem to say, Throw cares away.
Christmas is here, bringing good cheer
To young and old, meek and the bold
Ding, dong, ding, dong, that is their song
With joyful ring, all caroling.
One seems to hear words of good cheer
From everywhere, filling the air
O, how they pound, raising their sound
Over hill and dale, telling their tale

Gaily they ring, while people sing
Songs of good cheer, Christmas is here.
Merry, merry, merry, merry Christmas.
Merry, merry, merry, merry Christmas.

On, on they send, on without end
Their joyful tone to every home.
Ding dong ding dong.