/*
 * Copyright (C) 2017, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.procedure.perform;

import java.util.List;

import io.proleap.cobol.Cobol85Parser.PerformAfterContext;
import io.proleap.cobol.Cobol85Parser.PerformVaryingPhraseContext;
import io.proleap.cobol.asg.metamodel.CobolDivisionElement;

public interface VaryingClause extends CobolDivisionElement {

	After addAfter(PerformAfterContext ctx);

	VaryingPhrase addVaryingPhrase(PerformVaryingPhraseContext ctx);

	List<After> getAfters();

	VaryingPhrase getVaryingPhrase();

}
