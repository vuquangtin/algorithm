# Coin Piles

You have two coin piles containing a and b coins. On each move, you can either remove one coin from the left pile and two coins from the right pile, or two coins from the left pile and one coin from the right pile.

Your task is to efficiently find out if you can empty both the piles.

## Input

The first input line has an integer t: the number of tests.

After this, there are t lines, each of which has two integers a and b: the numbers of coins in the piles.

## Output

For each test, print "YES" if you can empty the piles and "NO" otherwise.

## Constraints


<li><span class="MathJax_Preview" style="color: inherit;"></span><span class="MathJax" id="MathJax-Element-7-Frame" tabindex="0" style="position: relative;" data-mathml="<math xmlns=&quot;http://www.w3.org/1998/Math/MathML&quot;><mn>1</mn><mo>&amp;#x2264;</mo><mi>t</mi><mo>&amp;#x2264;</mo><msup><mn>10</mn><mn>5</mn></msup></math>" role="presentation"><nobr aria-hidden="true"><span class="math" id="MathJax-Span-19" role="math" style="width: 5.828em; display: inline-block;"><span style="display: inline-block; position: relative; width: 4.968em; height: 0px; font-size: 117%;"><span style="position: absolute; clip: rect(1.38em, 1004.97em, 2.702em, -1000em); top: -2.404em; left: 0em;"><span class="mrow" id="MathJax-Span-20"><span class="mn" id="MathJax-Span-21" style="font-family: MathJax_Main;">1</span><span class="mo" id="MathJax-Span-22" style="font-family: MathJax_Main; padding-left: 0.278em;">≤</span><span class="mi" id="MathJax-Span-23" style="font-family: MathJax_Math; font-style: italic; padding-left: 0.278em;">t</span><span class="mo" id="MathJax-Span-24" style="font-family: MathJax_Main; padding-left: 0.278em;">≤</span><span class="msubsup" id="MathJax-Span-25" style="padding-left: 0.278em;"><span style="display: inline-block; position: relative; width: 1.429em; height: 0px;"><span style="position: absolute; clip: rect(3.18em, 1000.96em, 4.189em, -1000em); top: -4.006em; left: 0em;"><span class="mn" id="MathJax-Span-26" style="font-family: MathJax_Main;">10</span><span style="display: inline-block; width: 0px; height: 4.006em;"></span></span><span style="position: absolute; top: -4.399em; left: 1em;"><span class="mn" id="MathJax-Span-27" style="font-size: 70.7%; font-family: MathJax_Main;">5</span><span style="display: inline-block; width: 0px; height: 4.006em;"></span></span></span></span></span><span style="display: inline-block; width: 0px; height: 2.404em;"></span></span></span><span style="display: inline-block; overflow: hidden; vertical-align: -0.224em; border-left: 0px solid; width: 0px; height: 1.297em;"></span></span>
</li><li><span class="MathJax_Preview" style="color: inherit;"></span><span class="MathJax" id="MathJax-Element-8-Frame" tabindex="0" style="position: relative;" data-mathml="<math xmlns=&quot;http://www.w3.org/1998/Math/MathML&quot;><mn>0</mn><mo>&amp;#x2264;</mo><mi>a</mi><mo>,</mo><mi>b</mi><mo>&amp;#x2264;</mo><msup><mn>10</mn><mn>9</mn></msup></math>" role="presentation"><nobr aria-hidden="true"><span class="math" id="MathJax-Span-28" role="math" style="width: 7.016em; display: inline-block;"><span style="display: inline-block; position: relative; width: 5.983em; height: 0px; font-size: 117%;"><span style="position: absolute; clip: rect(1.38em, 1005.98em, 2.758em, -1000em); top: -2.404em; left: 0em;"><span class="mrow" id="MathJax-Span-29"><span class="mn" id="MathJax-Span-30" style="font-family: MathJax_Main;">0</span><span class="mo" id="MathJax-Span-31" style="font-family: MathJax_Main; padding-left: 0.278em;">≤</span><span class="mi" id="MathJax-Span-32" style="font-family: MathJax_Math; font-style: italic; padding-left: 0.278em;">a</span><span class="mo" id="MathJax-Span-33" style="font-family: MathJax_Main;">,</span><span class="mi" id="MathJax-Span-34" style="font-family: MathJax_Math; font-style: italic; padding-left: 0.167em;">b</span><span class="mo" id="MathJax-Span-35" style="font-family: MathJax_Main; padding-left: 0.278em;">≤</span><span class="msubsup" id="MathJax-Span-36" style="padding-left: 0.278em;"><span style="display: inline-block; position: relative; width: 1.429em; height: 0px;"><span style="position: absolute; clip: rect(3.18em, 1000.96em, 4.189em, -1000em); top: -4.006em; left: 0em;"><span class="mn" id="MathJax-Span-37" style="font-family: MathJax_Main;">10</span><span style="display: inline-block; width: 0px; height: 4.006em;"></span></span><span style="position: absolute; top: -4.399em; left: 1em;"><span class="mn" id="MathJax-Span-38" style="font-size: 70.7%; font-family: MathJax_Main;">9</span><span style="display: inline-block; width: 0px; height: 4.006em;"></span></span></span></span></span><span style="display: inline-block; width: 0px; height: 2.404em;"></span></span></span><span style="display: inline-block; overflow: hidden; vertical-align: -0.289em; border-left: 0px solid; width: 0px; height: 1.363em;"></span></span>
</li>


## Example

Input:

```
3
2 1
2 2
3 3
```

Output:

```
YES
NO
YES
```




