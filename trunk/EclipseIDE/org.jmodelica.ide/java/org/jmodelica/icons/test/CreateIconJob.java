package org.jmodelica.icons.test;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.jastadd.plugin.ui.view.AbstractBaseContentOutlinePage;
import org.jmodelica.icons.Icon;
import org.jmodelica.modelica.compiler.ClassDecl;
import org.jmodelica.ide.outline.OutlinePage;
/*
 * 1. ClassDecl.contentOutlineImage anropas. 
 * 		- Listan �ver ClassDecls som har ikoner kontrolleras f�r att se 
 * 			om ikonen finns. Om inte:
 * 			- Ett CreateIconJob schemal�ggs f�r att skapa ikonen.
 * 				- Anropar ClassDecl.icon().
 * 			- En tom bild returneras.
 * 2. CreateIconJob blir klart. 
 * 		- Den f�rdiga ikonen sparas p� ClassDeclen mha. lazy-cachning.
 * 		- ClassDeclen l�ggs till i listan �ver de klasser som har ikoner.
 * 3. ClassDecl.contentOutlineImage anropas igen (samma ClassDecl).
 * 		- ClassDeclen ligger nu i listan �ver klasser som har ikoner.
 * 			icon() ger d�rf�r den utr�knade ikonen.
 * 
 * Nackdelar:
 * 		- Ikonen hamnar inte i outlinen f�r�n contentOutlineImage anropas p� nytt.
 */
public class CreateIconJob extends Job {
	
	/**
	 * ClassDecl to create an icon for.
	 */
	ClassDecl decl;
	
	/**
	 * The outline that should be updated when the icon is done.
	 */
	AbstractBaseContentOutlinePage outline;
	
	public CreateIconJob(String name, ClassDecl decl, AbstractBaseContentOutlinePage outline) {
	super(name);
		this.addJobChangeListener(new CreateIconJobChangeListener(outline));
		this.decl = decl;
		this.outline = outline;
		IconStatus.nbrJobs++;
		System.out.println("Antal jobb = " + IconStatus.nbrJobs);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		if (outline == null) {
			// Avbryt.
			IconStatus.cancelIcon(decl);
			return Status.CANCEL_STATUS;
		}
		
		Icon icon = decl.icon();
		IconStatus.setHasFinishedIcon(decl);

		return Status.OK_STATUS;
	}
	
	private class CreateIconJobChangeListener implements IJobChangeListener {
		
		private AbstractBaseContentOutlinePage outline;
	
		public CreateIconJobChangeListener(AbstractBaseContentOutlinePage outline) {
			this.outline = outline;
		}
	
		@Override
		public void sleeping(IJobChangeEvent arg0) {}
		@Override
		public void scheduled(IJobChangeEvent arg0) {}
		@Override
		public void running(IJobChangeEvent arg0) {}
		
		@Override
		public void done(IJobChangeEvent arg0) {
			if (outline == null) {
				return;
			}
			
			Display.getDefault().syncExec(new Runnable() { 
				public void run() { 
					((OutlinePage)outline).update();
				}
			});
		}
		
		@Override
		public void awake(IJobChangeEvent arg0) {}
		@Override
		public void aboutToRun(IJobChangeEvent arg0) {}
	}
}
