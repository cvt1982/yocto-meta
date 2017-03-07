# Base this image on rpi-basic-image.bb
require recipes-core/images/rpi-basic-image.bb

#IMAGE_INSTALL_append = " example iproute2 mono python3 nodejs nano htop tcpdump screen usbutils wpa-supplicant hostapd linux-firmware keyboard"
IMAGE_INSTALL_append = " example iproute2 mono python3 nodejs nano htop tcpdump screen usbutils wpa-supplicant hostapd linux-firmware"

