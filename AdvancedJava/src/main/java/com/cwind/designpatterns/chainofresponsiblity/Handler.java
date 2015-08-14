package com.cwind.designpatterns.chainofresponsiblity;

public abstract class Handler {
	private Handler nexeHandler;
	
	public Handler getNexeHandler() {
		return nexeHandler;
	}

	public void setNexeHandler(Handler nexeHandler) {
		this.nexeHandler = nexeHandler;
	}

	public void handleRequest(Request req){
		if(this.getHandlerLevel().above(req.getLevel())){
			this.response(req);
		}else{
			if(this.getNexeHandler()!=null){
				this.getNexeHandler().handleRequest(req);
			}else{
				System.out.println("Can not find a proper handler.");
			}
		}
	}
	
	public abstract Level getHandlerLevel();
	public abstract Response response(Request req);
}
