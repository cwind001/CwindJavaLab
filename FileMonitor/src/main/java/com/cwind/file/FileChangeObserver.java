
package com.cwind.file;

/**
 * Simplistic class that notifies when files have changed.  Mostly should be used as a callback interfacae
 */
public interface FileChangeObserver
{
	 public void fileChanged(String filename);

}
