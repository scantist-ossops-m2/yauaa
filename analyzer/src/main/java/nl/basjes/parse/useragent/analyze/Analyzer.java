/*
 * Yet Another UserAgent Analyzer
 * Copyright (C) 2013-2020 Niels Basjes
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.basjes.parse.useragent.analyze;

import nl.basjes.parse.useragent.parse.AgentPathFragment;
import nl.basjes.parse.useragent.parse.MatcherTree;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Analyzer extends Serializable {
    void inform(AgentPathFragment path, String value, ParseTree<MatcherTree> ctx);

    void informMeAbout(MatcherAction matcherAction, MatcherTree keyPattern);

    default void receivedInput(Matcher matcher) {
        // Nothing to do
    }

    Map<String, Map<String, String>> getLookups();

    Map<String, Set<String>> getLookupSets();

    MatcherTree getMatcherTreeRoot();

    List<Map<String, Map<String, String>>> getTestCases();

    MatcherTree getMatcherTreeRoot();
}
