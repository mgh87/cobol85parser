/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.call;

import io.proleap.cobol.parser.metamodel.CobolScopedElement;
import io.proleap.cobol.parser.metamodel.NamedElement;

public interface Call extends CobolScopedElement, NamedElement {

	public enum CallType {
		DataDescriptionsEntryCall, ProcedureCall, UndefinedCall, VariableCall;
	}

	CallType getCallType();

	Call unwrap();
}