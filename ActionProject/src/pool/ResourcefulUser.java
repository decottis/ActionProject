package pool;

public class ResourcefulUser<R extends Resource> {
	protected R resource;

	public R getResource() {
		return this.resource;
	}

	public void setResource(R resource) {
		this.resource = resource;
	}

	public void resetResource() {
		this.resource = null;
	}
}
