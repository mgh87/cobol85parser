package io.proleap.cobol.asg.procedure.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Test;

import io.proleap.cobol.CobolTestBase;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.Call.CallType;
import io.proleap.cobol.asg.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.asg.metamodel.procedure.StatementTypeEnum;
import io.proleap.cobol.asg.metamodel.procedure.call.ByContent;
import io.proleap.cobol.asg.metamodel.procedure.call.ByContentPhrase;
import io.proleap.cobol.asg.metamodel.procedure.call.ByReference;
import io.proleap.cobol.asg.metamodel.procedure.call.ByReferencePhrase;
import io.proleap.cobol.asg.metamodel.procedure.call.ByValuePhrase;
import io.proleap.cobol.asg.metamodel.procedure.call.CallStatement;
import io.proleap.cobol.asg.metamodel.procedure.call.GivingPhrase;
import io.proleap.cobol.asg.metamodel.procedure.call.Parameter;
import io.proleap.cobol.asg.metamodel.procedure.call.UsingPhrase;
import io.proleap.cobol.asg.metamodel.valuestmt.CallValueStmt;
import io.proleap.cobol.asg.metamodel.valuestmt.ValueStmt;
import io.proleap.cobol.asg.runner.impl.CobolParserRunnerImpl;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class CallStatementTest extends CobolTestBase {

	@Test
	public void test() throws Exception {
		final File inputFile = new File("src/test/resources/io/proleap/cobol/asg/procedure/call/CallStatement.cbl");
		final Program program = new CobolParserRunnerImpl().analyzeFile(inputFile, CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("CallStatement");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final ProcedureDivision procedureDivision = programUnit.getProcedureDivision();
		assertEquals(0, procedureDivision.getParagraphs().size());
		assertEquals(1, procedureDivision.getStatements().size());

		{
			final CallStatement callStatement = (CallStatement) procedureDivision.getStatements().get(0);
			assertEquals(StatementTypeEnum.CALL, callStatement.getStatementType());

			{
				final ValueStmt programValueStmt = callStatement.getProgramValueStmt();
				assertNotNull(programValueStmt);

				final CallValueStmt programCallValueStmt = (CallValueStmt) programValueStmt;
				assertEquals(CallType.UNDEFINED_CALL, programCallValueStmt.getCall().getCallType());
			}

			{
				final GivingPhrase givingPhrase = callStatement.getGivingPhrase();
				assertNotNull(givingPhrase.getGivingCall());
				assertEquals(CallType.UNDEFINED_CALL, givingPhrase.getGivingCall().getCallType());
			}

			{
				final UsingPhrase usingPhrase = callStatement.getUsingPhrasePhrase();
				assertEquals(3, usingPhrase.getParameters().size());

				{
					final Parameter parameter = usingPhrase.getParameters().get(0);
					assertEquals(Parameter.ParameterType.REFERENCE, parameter.getParameterType());

					{
						final ByReferencePhrase byReferencePhrase = parameter.getByReferencePhrase();
						assertEquals(2, byReferencePhrase.getByReferences().size());

						{
							final ByReference byReference = byReferencePhrase.getByReferences().get(0);
							assertEquals(ByReference.ByReferenceType.INTEGER, byReference.getByReferenceType());
							assertEquals(CallType.UNDEFINED_CALL, byReference.getCall().getCallType());
						}

						{
							final ByReference byReference = byReferencePhrase.getByReferences().get(1);
							assertNull(byReference.getByReferenceType());
							assertEquals(CallType.UNDEFINED_CALL, byReference.getCall().getCallType());
						}
					}
				}

				{
					final Parameter parameter = usingPhrase.getParameters().get(1);
					assertEquals(Parameter.ParameterType.VALUE, parameter.getParameterType());

					final ByValuePhrase byValuePhrase = parameter.getByValuePhrase();
					assertEquals(3, byValuePhrase.getValueStmts().size());

					{
						final ValueStmt valueStmt = byValuePhrase.getValueStmts().get(0);
						assertEquals(1, valueStmt.getValue());
					}

					{
						final ValueStmt valueStmt = byValuePhrase.getValueStmts().get(1);
						assertEquals(2, valueStmt.getValue());
					}

					{
						final ValueStmt valueStmt = byValuePhrase.getValueStmts().get(2);
						assertNotNull(valueStmt);
					}
				}

				{
					final Parameter parameter = usingPhrase.getParameters().get(2);
					assertEquals(Parameter.ParameterType.CONTENT, parameter.getParameterType());

					{
						final ByContentPhrase byContentPhrase = parameter.getByContentPhrase();
						assertEquals(3, byContentPhrase.getByContents().size());

						{
							final ByContent byContent = byContentPhrase.getByContents().get(0);
							assertEquals(ByContent.ByContentType.ADDRESS_OF, byContent.getByContentType());
							assertNotNull(byContent.getValueStmt());

							final CallValueStmt callValueStmt = (CallValueStmt) byContent.getValueStmt();
							assertEquals(CallType.UNDEFINED_CALL, callValueStmt.getCall().getCallType());
						}

						{
							final ByContent byContent = byContentPhrase.getByContents().get(1);
							assertEquals(ByContent.ByContentType.LENGTH_OF, byContent.getByContentType());
							assertNotNull(byContent.getValueStmt());

							final CallValueStmt callValueStmt = (CallValueStmt) byContent.getValueStmt();
							assertEquals(CallType.UNDEFINED_CALL, callValueStmt.getCall().getCallType());
						}

						{
							final ByContent byContent = byContentPhrase.getByContents().get(2);
							assertNull(byContent.getByContentType());
							assertNotNull(byContent.getValueStmt());

							assertEquals(4, byContent.getValueStmt().getValue());
						}
					}
				}
			}
		}
	}
}
