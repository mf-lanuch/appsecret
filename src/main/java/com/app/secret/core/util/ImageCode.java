package com.app.secret.core.util;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/*
 * Devil
 * 2019年12月23日
 */
public class ImageCode extends ImageCodeService{
	public ImageCode() {
    }

    public ImageCode(int width, int height) {
        this();
        this.setWidth(width);
        this.setHeight(height);
    }

    public ImageCode(int width, int height, int len) {
        this(width, height);
        this.setLen(len);
    }

    public ImageCode(int width, int height, int len, Font font) {
        this(width, height, len);
        this.setFont(font);
    }

    public boolean out(OutputStream out) {
        this.checkAlpha();
        return this.graphicsImage(this.textChar(), out);
    }

    private boolean graphicsImage(char[] strs, OutputStream out) {
        boolean ok;
        try {
            BufferedImage bi = new BufferedImage(this.width, this.height, 1);
            Graphics2D g = (Graphics2D)bi.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.width, this.height);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setStroke(new BasicStroke(1.3F, 0, 2));
            this.drawLine(3, g);
            this.drawOval(8, g);
            AlphaComposite ac3 = AlphaComposite.getInstance(3, 0.8F);
            g.setComposite(ac3);
            int hp = this.height - this.font.getSize() >> 1;
            int h = this.height - hp;
            int w = this.width / strs.length;
            int sp = (w - this.font.getSize()) / 2;

            for(int i = 0; i < strs.length; ++i) {
                g.setColor(new Color(20 + num(110), 20 + num(110), 20 + num(110)));
                int x = i * w + sp + num(3);
                int y = h - num(3, 6);
                if (x < 8) {
                    x = 8;
                }

                if (x + this.font.getSize() > this.width) {
                    x = this.width - this.font.getSize();
                }

                if (y > this.height) {
                    y = this.height;
                }

                if (y - this.font.getSize() < 0) {
                    y = this.font.getSize();
                }

                g.setFont(this.font.deriveFont(num(2) == 0 ? 0 : 2));
                g.drawString(String.valueOf(strs[i]), x, y);
            }

            ImageIO.write(bi, "png", out);
            out.flush();
            ok = true;
        } catch (IOException var22) {
            ok = false;
            var22.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException var21) {
                var21.printStackTrace();
            }

        }

        return ok;
    }
}
