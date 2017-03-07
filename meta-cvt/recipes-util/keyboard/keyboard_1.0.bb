#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

SUMMARY = "Setup a default (danish) keyboard-layout for the console only"
SECTION = "keyboard-layout"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
RDEPENDS_${PN} = "initscripts console-tools"

inherit update-rc.d

SRC_URI = "file://keymap.sh \
           file://dk-latin1.map \
           file://qwerty-layout.inc \
           file://linux-with-alt-and-altgr.inc \
           file://compose.inc \
           file://linux-keys-bare.inc  "

S = "${WORKDIR}"

INITSCRIPT_NAME = "keymap.sh"
INITSCRIPT_PARAMS = "start 99 5 2 S ."
#INITSCRIPT_PARAMS = "start 01 S ."

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/keymap
    install -m 0755 ${WORKDIR}/keymap.sh ${D}${sysconfdir}/init.d/
    install -m 0644 ${WORKDIR}/dk-latin1.map ${D}${sysconfdir}/keymap
    install -m 0644 ${WORKDIR}/qwerty-layout.inc ${D}${sysconfdir}/keymap/qwerty-layout
    install -m 0644 ${WORKDIR}/linux-with-alt-and-altgr.inc ${D}${sysconfdir}/keymap/linux-with-alt-and-altgr
    install -m 0644 ${WORKDIR}/compose.inc ${D}${sysconfdir}/keymap/compose
    install -m 0644 ${WORKDIR}/linux-keys-bare.inc ${D}${sysconfdir}/keymap/linux-keys-bare
}
