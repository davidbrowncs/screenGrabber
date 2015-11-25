import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;

public class MouseListener implements NativeMouseListener, NativeMouseMotionListener
{
	private int x;
	private int y;
	private ScreenGetter g;

	public MouseListener(ScreenGetter g)
	{
		this.g = g;
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0)
	{

	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0)
	{
		if (g.primed())
		{
			g.createRect(arg0.getX(), arg0.getY());
		}
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0)
	{
		if (g.primed())
		{
			g.hideWindow();
			g.toClipboard();
			g.releaseRect();
			g.prime(false);
		}
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0)
	{
		if (g.primed())
		{
			g.updateRectangle(arg0.getX(), arg0.getY());
		}
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0)
	{}

}
