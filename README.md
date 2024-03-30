# whitakers-clj

`whitakers-clj` is a Clojure wrapper around Whitaker's Words.
Whitaker's Words can be found here: https://github.com/mk270/whitakers-words

This project is still under active development and is fairly incomplete.

Whitaker's Words produces output like:
```
$ ./bin/words agricolarum
agricol.arum         N      1 1 GEN P M                 
agricola, agricolae  N (1st) M   [XAXBO]  
farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;
agricolar.um         ADJ    3 2 GEN P X POS             
agricolaris, agricolaris, agricolare  ADJ   [XAXES]    uncommon
farmer-; relating to farmers;
```

`whitakers-clj` parses that into a Clojure object:
```
[{:options
  [{:sectioned-word "agricol.arum",
    :stem "agricol",
    :ending "arum",
    :part-of-speech :noun,
    :declension 1,
    :case :genitive,
    :number :plural,
    :gender :masculine}],
  :part-of-speech :noun,
  :dictionary-entry "agricola, agricolae",
  :definition
  "farmer, cultivator, gardener, agriculturist; plowman, countryman, peasant;",
  :dictionary-code
  {:age nil,
   :area "Agriculture, Flora, Fauna, Land, Equipment, Rural",
   :geo nil,
   :freq-code :B,
   :freq-text "In top 10 percent",
   :source "Oxford Latin Dictionary, 1982 (OLD)"}}
 {:options
  [{:number :plural,
    :part-of-speech :adjective,
    :declension 3,
    :sectioned-word "agricolar.um",
    :type :positive,
    :case :genitive,
    :stem "agricolar",
    :gender nil,
    :ending "um"}],
  :part-of-speech :adjective,
  :dictionary-entry "agricolaris, agricolaris, agricolare",
  :definition "farmer-; relating to farmers;",
  :dictionary-code
  {:age nil,
   :area "Agriculture, Flora, Fauna, Land, Equipment, Rural",
   :geo nil,
   :freq-code :E,
   :freq-text "Uncommon, 2 or 3 citations",
   :source "Lewis and Short, A Latin Dictionary, 1879 (L+S)"}}]
```

## Usage
Before using, `PATH_TO_WHITAKERS_WORDS_ROOT_FOLDER` in `core.clj` will need set.
I recommend checking out Whitaker's Words into a directory parallel with this repository.

Also, Whitaker's words will need modified. In `src/support_utils/support_utils-developer_parameters.adb`, set Pause_In_Screen_Output to False.
```
      Do_I_For_J                  => False,
      Do_U_For_V                  => False,
 
-     Pause_In_Screen_Output      => True,
+     Pause_In_Screen_Output      => False,
      No_Screen_Activity          => False,
 
      Update_Local_Dictionary     => False,
```

Then run this program like:
```
lein run -- Volo edere lardum
``
or like
```
lein run -- myInputFile.txt
```


## License

Copyright © 2024 Aaron Decker

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
