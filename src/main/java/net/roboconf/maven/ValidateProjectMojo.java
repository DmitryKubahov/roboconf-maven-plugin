/**
 * Copyright 2014 Linagora, Université Joseph Fourier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.roboconf.maven;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * The mojo in charge of checking the project structure.
 * @author Vincent Zurczak - Linagora
 */
@Mojo( name="validate-project", defaultPhase = LifecyclePhase.VALIDATE )
public class ValidateProjectMojo extends AbstractMojo {

	@Parameter( defaultValue = "${project}", readonly = true )
	private MavenProject project;


	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {

		File appDirectory = new File( this.project.getBasedir(), MavenPluginConstants.SOURCE_MODEL_DIRECTORY );
		if( ! appDirectory.exists())
			throw new MojoFailureException( "The " + MavenPluginConstants.SOURCE_MODEL_DIRECTORY + " directory does not exist." );

		if( ! appDirectory.isDirectory())
			throw new MojoFailureException( "The " + MavenPluginConstants.SOURCE_MODEL_DIRECTORY + " path does not point to a directory." );
	}
}
